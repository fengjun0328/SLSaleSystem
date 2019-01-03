var path=$("#path").val();
$("#loginBtn").click(function(){
   loginCode = $.trim($("#logincode").val());
   password = $.trim($("#password").val());
    isStart = 1;
    if(loginCode == "" || loginCode == null){
        $("#logincode").focus();
        $("#formtip").css("color","red");
        $("#formtip").html("对不起，登录账号不能为空。");
    }else if(password == "" || password == null){
        $("#password").focus();
        $("#formtip").css("color","red");
        $("#formtip").html("对不起，登录密码不能为空。");
    }else{
        $("#formtip").html("");
        $.ajax({
            url: path+'/login',
            type: 'POST',
            data:{"loginCode":loginCode,"password":password},
            dataType: 'text',
            timeout: 1000,
            error: function(){
                $("#formtip").css("color","red");
                $("#formtip").html("登录失败！请重试。");
            },
            success: function(result){
                if(result != "" && 'success' == result){
                    window.location.href=path+'/main.html';
                }else if('failed' == result){
                    $("#formtip").css("color","red");
                    $("#formtip").html("登陆失败！请重试。");
                    $("#logincode").val('');
                    $("#password").val('');
                }
                else if("nologincode"==result){
                    $("#formtip").css("color","red");
                    $("#formtip").html("登录账号不存在，请重试。");
                }else if("pwderror" == result){
                    $("#formtip").css("color","red");
                    $("#formtip").html("登录密码错误，请重试。");
                }
            }
        });
    }
});