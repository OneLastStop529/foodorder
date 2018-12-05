<html>
<#include "../common/header.ftl">

<body>
<div id="wrapper" class="toggled">


    <#include "../common/nav.ftl">



<div class="container-fluid">
    <div id="page-content-wrapper">
        <div class="row clearfix">
            <div class="col-md-12 column">
                <table class="table table-condensed table-hover table-bordered">
                    <thead>
                    <tr>
                        <th>订单ID</th>
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
                            <td>${orderDTO.orderStatusEnum.getMessage()}</td>
                            <td>${orderDTO.payStatusEnum.getMessage()}</td>
                            <td>${orderDTO.createTime}</td>
                            <td><a href="/sell/seller/order/detail?orderId=${orderDTO.orderId}">详情</a></td>
                            <td>
                                <#if orderDTO.getOrderStatusEnum() == "NEW">
                                    <a href="/sell/seller/order/cancel?orderId=${orderDTO.orderId}">取消</a>
                                </#if>
                            </td>
                        </tr>


                    </#list>




                    </tbody>
                </table>
            </div>
                <ul class="pagination pull-right">

                        <#if currentPage lte 1>
                            <li><a  class="disabled" href="#">Prev</a></li>
                        <#else>
                            <li> <a  href="/sell/seller/order/list?page=${currentPage - 1}&size=${size}">Prev</a></li>
                        </#if>
                    <#list 1..orderDTOPage.getTotalPages() as index>
                    <#if currentPage == index>
                        <li class="disabled"><a href="#">${index}</a></li>
                    <#else>
                        <li><a href="/sell/seller/order/list?page=${index}&size=${size}">${index}</a></li>
                    </#if>
                    </#list>

                        <#if currentPage gte orderDTOPage.getTotalPages()>
                            <li><a href="#">Next</a></li>
                            <#else>
                            <li><a href="/sell/seller/order/list?page=${currentPage + 1}&size=${size}">Next</a></li>
                        </#if>
                </ul>

        </div>
    </div>
</div>

</body>

</html>
