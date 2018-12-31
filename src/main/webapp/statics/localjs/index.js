var path=$("#path").val();
$("#loginBtn").click(function () {
    var loginCode=$("#logincode").val();
    var password=$("#password").val();
    if(loginCode==""|| loginCode==null){
        $("#logincode").focus();
        $("#formtip").css("color","red");
        $("#formtip").html("登录名不能为空");
    }else  if(password==""||password==null){
        $("#logincode").focus();
        $("#formtip").css("color","red");
        $("#formtip").html("密码不能为空");
    }else{
        $("#formtip").html("");
        $.ajax({
            url: path+'/user/login.html',
            type: 'POST',
            data:{"loginCode":loginCode,"password":password},
            timeout: 1000,
            error: function(){
                $("#formtip").css("color","red");
                $("#formtip").html("登录有问题");
            },
            success: function(result){
                alert(result)
                if(result != "" && 1== result){
                    window.location.href=path+'/user/main.html';
                }else if(-2== result){
                    $("#formtip").css("color","red");
                    $("#formtip").html("登陆失败！请重试。");
                    $("#logincode").val('');
                    $("#password").val('');
                } else if(-1== result){
                    $("#formtip").css("color","red");
                    $("#formtip").html("登录账号不存在，请重试。");
                }else if(2 == result){
                    $("#formtip").css("color","red");
                    $("#formtip").html("对不起，没有任何数据需要处理！请重试。");
                }else if(0 == result){
                    $("#formtip").css("color","red");
                    $("#formtip").html("登录密码错误，请重试。");
                }
            }
        });
    }
});