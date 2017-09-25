/**
 * Created by xieyuhan on 2017/9/24.
 */
window.onload=searchByColor($("#红色"));
function searchByColor(obj){
    var keyword = $(obj).attr("id");
    console.log(keyword);
    var type = "color";
    var byPage = "true";
    var page = 1;
    var count = 15;
    var json = {keyword: keyword, type: type, byPage: byPage, page: page, count: count};

    $.ajax({
        url: "search",
        method: "GET",
        dateType: "json",
        data: json,
        success: function (data) {
            console.log(data);
            if(data.result =="success"){
                console.log($("#pic"));
                $("#pic").empty();

                var text = "";
                for (var i=0;i<data.object.length;i++){

                    text+='<img src= ' + data.object[i].description +' id='+data.object[i].itemId+' class="product" '+'onclick="itemDetail('+data.object[i].itemId+')">'

                }
                $("#pic").html(text);

            }else if (data.code == 13) {
                // 出错的处理
                layer.msg('请 重 试 ！');
            }
        }
    })
}
function itemDetail(id) {
    layer.open({
        type: 2, //弹出层的类型
        title: '',//弹出框的标题
        maxmin: false,//最大最小化
        shadeClose: true, //点击遮罩关闭层
        area : ['800px' , '520px'],//区域大小面积
        content: 'itemDetail?itemId=id'//打开之后呈现的html内容
    });
}