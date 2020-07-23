Type=Class
Version=6.5
ModulesStructureVersion=1
B4A=true
@EndOfDesignText@
'Class module
Sub Class_Globals
	
End Sub

'Initializes the object. You can add parameters to this method if needed.
Public Sub Initialize

End Sub

'get filename of fullpath
Sub GetFilename(fullpath As String) As String
   Return fullpath.SubString(fullpath.LastIndexOf("/") + 1)
End Sub

'get extension of filename
Sub GetFileExt(FullPath As String) As String
  Return FullPath.SubString(FullPath.LastIndexOf(".")+1)
End Sub

'get basename of fullpath
Sub GetBasename(fullpath As String) As String
   Dim filename As String
   filename = GetFilename(fullpath)
   Return filename.SubString2(0,filename.LastIndexOf("."))
End Sub

'get address of path
Sub GetPath(Path As String) As String
   Dim Path1 As String
   If Path = "/" Then
      Return "/"
   End If
   L = Path.LastIndexOf("/")
   If L = Path.Length - 1 Then
      'Strip the last slash
      Path1 = Path.SubString2(0,L)
   Else
      Path1 = Path
   End If
   L = Path.LastIndexOf("/")
   If L = 0 Then
      L = 1
   End If
   Return Path1.SubString2(0,L)
End Sub

'rename file
Sub RenameFile(OriginalFileName As String, NewFileName As String) As Boolean
    Dim Result As Int
    Dim StdOut, StdErr As StringBuilder
    StdOut.Initialize
    StdErr.Initialize
    Dim Ph As Phone
    Result = Ph.Shell("mv " & OriginalFileName & " " & NewFileName, Null,  StdOut, StdErr)
    If Result = 0 Then
        Return True
    Else
        Return False
    End If
End Sub


'rename folder
Sub RenameFolder(Parent As String, CurrentFolder As String, NewFolder)
	Dim p As Phone
	Dim args(2) As String
	args(0) = File.Combine(Parent, CurrentFolder)
	args(1) = File.Combine(Parent, NewFolder)
	p.Shell("mv", args, Null, Null)
End Sub

