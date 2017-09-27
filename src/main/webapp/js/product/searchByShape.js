/**
 * Created by xieyuhan on 2017/9/24.
 */
window.onload=searchByShape($("#圆形"));
function searchByShape(obj){
    var keyword = $(obj).attr("id");
    if(keyword == "shape")keyword = "circle";
    console.log(keyword);
    var type = "shape";
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
                $("#pic").empty();
                var text = "";
                for (var i=0;i<data.object.length;i++){
                    text+='<img alt="商品图片" src="' + data.object[i].description +'" id="'+data.object[i].itemId+'" class="product" '+'onclick="itemDetail(\''+data.object[i].itemId+'\')">'
                }
                $("#pic").append(text);

            }else if (data.code == 13) {
                // 出错的处理
                layer.msg('请 重 试 ！');
            }
        }
    })
}