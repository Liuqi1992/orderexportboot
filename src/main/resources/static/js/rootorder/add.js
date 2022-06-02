function addRootOrder() {
    layui.use(['layer', 'form'], function() {
        var layer = layui.layer;
        var form = layui.form;
        layer.open({
            type: 1,
            title: "新增客户",
            area: ["560px", "360px"],
            content: $("#add_rootOrder"),
            btn: ["增加", "取消"],
            yes: function(index, layero) {
                $.ajax({
                    url: "/rootorder/add",
                    type: "POST",
                    data: $("#add_rootOrder_form").serializeArray(),
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