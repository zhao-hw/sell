<html>
    <head>
        <meta charset="utf-8">
        <title>卖家商品列表</title>
        <#include "../common/head.ftl">
    </head>
    <body>
        <div id="wrapper" class="toggled">
            <#--sidebar-->
            <#include "../common/nav.ftl">
                <#--content-->
            <div id="page-content-wrapper">
                <div class="container-fluid">
                    <div class="row clearfix">
                    <#--列表-->
                        <div class="col-md-12 column">
                            <table class="table table-bordered">
                                <thead>
                                <tr>
                                    <th>订单id</th>
                                    <th>姓名</th>
                                    <th>手机号</th>
                                    <th>地址</th>
                                    <th>金额</th>
                                    <th>订单状态</th>
                                    <th>支付状态</th>
                                    <th>创建时间</th>
                                    <th colspan="2">操作</th>
                                </tr>
                                </thead>
                                <tbody>
                                <#list orderDTOPage.content as orderDTO>
                                <tr>
                                    <td>${orderDTO.orderId}</td>
                                    <td>${orderDTO.buyerName}</td>
                                    <td>${orderDTO.buyerPhone}</td>
                                    <td>${orderDTO.buyerAddress}</td>
                                    <td>${orderDTO.orderAmount}</td>
                                    <td>${orderDTO.getOrderStatusEnum().msg}</td>
                                    <td>${orderDTO.getPayStatusEnum().msg}</td>
                                    <td>${orderDTO.createTime}</td>
                                    <td>
                                        <a href="/sell/seller/order/detail?orderId=${orderDTO.orderId}"/> 详情
                                    </td>

                                    <#if orderDTO.getOrderStatusEnum().msg == "新订单">
                                        <td>
                                            <a href="/sell/seller/order/cancel?orderId=${orderDTO.orderId}"/> 取消
                                        </td>
                                    <#else >
                                        <td class="disabled">取消</td>
                                    </#if>
                                </tr>
                                </#list>
                                </tbody>
                            </table>
                        </div>
                    <#--分页-->
                        <div class="col-md-12 column">
                            <ul class="pagination pull-right">
                            <#if currentPage lte 1>
                                <li class="disabled"><a href="#">上一页</a></li>
                            <#else >
                                <li><a href="/sell/seller/order/list?page=${currentPage-1}&&size=${size}">上一页</a></li>
                            </#if>
                            <#list 1..orderDTOPage.getTotalPages() as index>
                                <#if currentPage == index>
                                    <li class="disabled"><a href="/sell/seller/order/list?page=${index}&&size=${size}">${index}</a><li>
                                <#else >
                                    <li><a href="/sell/seller/order/list?page=${index}&&size=${size}">${index}</a></li>
                                </#if>
                            </#list>
                            <#if currentPage gte orderDTOPage.getTotalPages()>
                                <li class="disabled"><a href="#">下一页</a></li>
                            <#else >
                                <li><a href="/sell/seller/order/list?page=${currentPage+1}&&size=${size}">下一页</a></li>
                            </#if>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    <#--<script>-->
        <#--var websocket = null;-->
        <#--if ('WebSocket' in window) {-->
            <#--websocket = new WebSocket('ws://bravo.natapp1.cc/sell/webSocket');-->
        <#--} else {-->
            <#--alert('该浏览器不支持websocket!');-->
        <#--}-->

        <#--websocket.onopen = function (event) {-->
            <#--console.log('建立连接');-->
        <#--}-->

        <#--websocket.onclose = function (event) {-->
            <#--console.log('连接关闭');-->
        <#--}-->

        <#--websocket.onmessage = function (event) {-->
            <#--console.log('收到消息:'+event.data);-->
            <#--//弹窗提醒，播放音乐-->
        <#--}-->

        <#--websocket.onerror = function () {-->
            <#--alert('websocket通信发生错误');-->
        <#--}-->

        <#--window.onbeforeunload = function () {-->
            <#--websocket.close();-->
        <#--}-->
    <#--</script>-->
    </body>
</html>