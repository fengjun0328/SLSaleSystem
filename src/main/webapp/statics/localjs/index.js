var path=$("#path").val();
    $("#logincode").blur(function () {
        loginCode = $.trim($("#logincode").val());
        $("#formtip").html("");
        if(loginCode == "" || loginCode == null){
            $("#logincode").focus();
            $("#formtip").css("color","red");
            $("#formtip").html("对不起，登录账号不能为空。");
        }else{
            $.get(path+"/logincodeisexit","loginCode="+loginCode,function (data) {
                if(data=="false"){
                    $("#formtip").html("登录账号不存在");
                }
            });
        }
    });

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
            $.post( path+'/login',{"loginCode":loginCode,"password":password},function (result) {
                if(result){
                    window.location.href=path+'/main.html';
                }else{
                    $("#formtip").css("color","red");
                    $("#formtip").html("用户名和密码不符");
                    $("#logincode").val('');
                    $("#password").val('');
                }
            },"json");
        }
    });

