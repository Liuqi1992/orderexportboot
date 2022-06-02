function deleteCustom(ids) {
    $.ajax({
        url: "/custom/delete",
        type: "POST",
        data: {"ids": ids, "_method":"DELETE"},
        dataType: "json",
        success: function(data) {
            if(data.code == 0) {
                layer.msg("删除成功", {
                    time: 1000
                });
            } else {
                var msg = "删除失败:" + data.msg
                layer.msg(msg, {
                    time: 1000
                });
            }
            setTimeout(function() {
                location.reload();
            }, 1000)
        },
        error: function(er) {
            console.log(er);
        }
    });
}