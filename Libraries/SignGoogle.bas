Type=Class
Version=6
ModulesStructureVersion=1
B4A=true
@EndOfDesignText@

Private Sub Class_Globals
	Private clientId As String : clientId = "" 'enter client id here
	'Private clientSecret As String : clientSecret = "" 'client secret here
	Private AccessToken As String
	Private userInfoLink As String : userInfoLink = "https://www.googleapis.com/oauth2/v1/userinfo"
	Private m_GoogleAccountManager As clsB_GoogleAccountManager
	Private modules As Object
	Private evt As String
	Private l_GoogleAccounts() As Object
End Sub

'Step 1
Public Sub Initialize(sClientID As String,module As Object)
	
	clientId		= sClientID
	m_GoogleAccountManager.Initialize(0)
	modules			= module
	
End Sub

'Step 3
Sub SelectAccount(AccountName As String)
	
	For Each l_joAccount As JavaObject In l_GoogleAccounts
		If l_joAccount.GetField ("name") = AccountName Then
			Exit
		End If
	Next
	
	Dim l_sScopes As String = "email profile"
	Dim l_sAuthTokenType As String = $"oauth2:${l_sScopes}"$
	Dim l_sAccessToken As String = m_GoogleAccountManager.getAuthToken_foreground(l_joAccount,l_sAuthTokenType)
	
	AccessToken = l_sAccessToken
	
End Sub

'Step 2
Sub GetAccountList As List
	
	l_GoogleAccounts = m_GoogleAccountManager.getAccountsByType("com.google")
	
	If l_GoogleAccounts.Length = 0 Then Return Null
	
	Dim l_sAccountNames As List : l_sAccountNames.Initialize
	
	For Each l_joAccount As JavaObject In l_GoogleAccounts
		Dim l_sAccountName As String = l_joAccount.GetField ("name")
		l_sAccountNames.Add(l_sAccountName)
	Next
	
	Return l_sAccountNames
	
End Sub

'Step 4
Sub RequestSign(Event As String)
	
	evt = Event
	
	Dim j As HttpJob
	j.Initialize("getUserDetails", Me)
	j.Download2(userInfoLink, Array As String("access_token",AccessToken))
	
End Sub

Private Sub JobDone(Job As HttpJob)
	
	ProgressDialogHide
	
	If Job.Success Then
		
		Select Job.JobName
			
			Case "GetAccessToken"
				Dim JSON As JSONParser
				Dim map1 As Map
				JSON.Initialize(Job.GetString)	
				map1=JSON.NextObject
				AccessToken=map1.Get("access_token")
				CallSub3(modules,evt,map1,False)
					
			Case "getUserDetails"
				Dim JSON As JSONParser
				Dim map1 As Map
				JSON.Initialize(Job.GetString)	
				map1 = JSON.NextObject
				CallSub3(modules,evt,map1,True)
				
		End Select
		
	Else
		Log("error")
	End If
	
	Job.Release
	
End Sub