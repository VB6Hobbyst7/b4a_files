Type=Service
Version=7.28
ModulesStructureVersion=1
B4A=true
@EndOfDesignText@
'version 2.62
'Service module
Sub Process_Globals
#if B4A or B4J
	Private hc As OkHttpClient
#else
	Private hc As HttpClient
#end if
	Private TaskIdToJob As Map
	Public TempFolder As String
	Private taskCounter As Int
End Sub

Sub Service_Create
#if B4A
	TempFolder = File.DirInternalCache
	Try
		File.WriteString(TempFolder, "~test.test", "test")
		File.Delete(TempFolder, "~test.test")
	Catch
		Log(LastException)
		Log("Switching to File.DirInternal")
		TempFolder = File.DirInternal
	End Try
#Else If B4J
	TempFolder = File.DirTemp
#End If
	hc.Initialize("hc")
	TaskIdToJob.Initialize
End Sub
#If B4A
Sub Service_Start (StartingIntent As Intent)
End Sub

Sub Service_Destroy

End Sub
#End If

Public Sub SubmitJob(job As HttpJob)
	If hc.IsInitialized = False Then Service_Create
	taskCounter = taskCounter + 1
	TaskIdToJob.Put(taskCounter, job)
	If job.Username <> "" And job.Password <> "" Then
		hc.ExecuteCredentials(job.GetRequest, taskCounter, job.Username, job.Password)
	Else
		hc.Execute(job.GetRequest, taskCounter)
	End If
End Sub


#if B4A or B4J
Sub hc_ResponseSuccess (Response As OkHttpResponse, TaskId As Int)
	Response.GetAsynchronously("response", File.OpenOutput(TempFolder, TaskId, False), _
		True, TaskId)
End Sub

Sub Response_StreamFinish (Success As Boolean, TaskId As Int)
	If Success Then
		CompleteJob(TaskId, Success, "")
	Else
		CompleteJob(TaskId, Success, LastException.Message)
	End If
End Sub

Sub hc_ResponseError (Response As OkHttpResponse, Reason As String, StatusCode As Int, TaskId As Int)
	Log($"ResponseError. Reason: ${Reason}, Response: ${Response.ErrorResponse}"$)
	Response.Release
	If Response.ErrorResponse <> "" Then
		CompleteJob(TaskId, False, Response.ErrorResponse)
	Else
		CompleteJob(TaskId, False, Reason)
	End If
End Sub
#Else
Sub hc_ResponseError (Response As HttpResponse, Reason As String, StatusCode As Int, TaskId As Int)
	Log("ResponseError: " & Reason & ", status code: " & StatusCode)
	CompleteJob(TaskId, False, Reason, Null)
End Sub

Sub hc_ResponseSuccess (Response As HttpResponse, TaskId As Int)
	CompleteJob(TaskId, True, "", Response)
End Sub
#End If

#If B4A or B4J
Sub CompleteJob(TaskId As Int, success As Boolean, errorMessage As String)
#Else
Sub CompleteJob(TaskId As Int, success As Boolean, errorMessage As String, res As HttpResponse)
#End If
	Dim job As HttpJob = TaskIdToJob.Get(TaskId)
	TaskIdToJob.Remove(TaskId)
	job.success = success
	job.errorMessage = errorMessage
#if B4A or B4J
	job.Complete(TaskId)
#Else
	job.Complete(res)
#End If
End Sub



