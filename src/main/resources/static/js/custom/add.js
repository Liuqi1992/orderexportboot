function addCustom() {
    layui.use(['layer', 'form'], function() {
        var layer = layui.layer;
        var form = layui.form;
        layer.open({
            type: 1,
            title: "新增客户",
            area: ["560px", "580px"],
            content: $("#add_custom"),
            btn: ["增加", "取消"],
            yes: function(index, layero) {
                $.ajax({
                    url: "/custom/add",
                    type: "POST",
                    data: $("#add_custom_form").serializeArray(),
                    dataType: "json",
                    success: function(data) {
                        if(data.code == 0) {
                            layer.msg("添加成功", {
                                time: 1000
                            });
                        } else {
                            layer.msg("添加失败", {
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
            },
            btn2: function(index, layero) {
                layer.close(index);
            }
        });
        form.render();
    });
}