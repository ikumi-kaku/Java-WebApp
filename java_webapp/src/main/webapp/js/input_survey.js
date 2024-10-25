var elmSubmit = document.getElementById("NEW_SUBMIT");
elmSubmit.onclick = function(){
  var elmNewUserId   = document.getElementById("NEW_USER_ID");
  var elmNewUserName = document.getElementById("NEW_ID_NAME");
  var elmNewPassword = document.getElementById("NEW_ID_PASS");
  var canSubmit = true;

  // UserIdのバリデーション
  if (elmNewUserId.value == "" || !(elmNewUserId.value.match("^[a-zA-Z0-9-_]+$"))) {
    canSubmit = false;
  }

  // UserNameのバリデーション
  if (elmNewUserName.value == "") {
    canSubmit = false;
  }

  // Passwordのバリデーション
  if (elmNewPassword.value == "" || !(elmNewPassword.value.match("^[a-zA-Z0-9-_]+$"))) {
    canSubmit = false;
  }

  // いずれかのバリデーションに失敗した場合、アラートを表示
  if (!canSubmit) {
    alert("入力が正しくありません。");
  }

  return canSubmit;
}
