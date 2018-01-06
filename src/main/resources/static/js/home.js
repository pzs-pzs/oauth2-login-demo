function github_profile() {
    /**
     * 防止跨站请求伪造
     */
    $.ajaxSetup({
            beforeSend : function(xhr, settings) {
                if (settings.type == 'POST' || settings.type == 'PUT'
                    || settings.type == 'DELETE') {
                    if (!(/^http:.*/.test(settings.url) || /^https:.*/
                            .test(settings.url))) {
                        // Only send the token to relative URLs i.e. locally.
                        xhr.setRequestHeader("X-XSRF-TOKEN",
                            getCookie('XSRF-TOKEN'));
                    }
                }
            }
    });


    // $.get("/demo", function(data) {
    //     $("#user").html(data['login'])
    //     // $("#pic").src=data['avatar_url'];
    //     $('#pic').attr('src', data['avatar_url']);
    //
    //     $("#github").show();
    // });
}

function getCookie(c_name) {
    if (document.cookie.length>0)
    {
        c_start=document.cookie.indexOf(c_name + "=")
        if (c_start!=-1)
        {
            c_start=c_start + c_name.length+1
            c_end=document.cookie.indexOf(";",c_start)
            if (c_end==-1) c_end=document.cookie.length
            return unescape(document.cookie.substring(c_start,c_end))
        }
    }
    return ""
}
function logout() {
    $.post("/logout", function() {
        window.location.href="/";
    });
}