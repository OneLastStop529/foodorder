<body>

<form>

    <div class="radio">
        <label>
            <p><input type="radio" name="demo1" id="demo1-alipay" value="option1" checked="">
                支付宝支付</p>
        </label>
    </div>
    <div class="radio">
        <label>
            <p><input type="radio" name="demo1" id="demo1-weixin" value="option2">
                微信支付</p>
        </label>
    </div>
    <button type="button" id="demoBtn1">确认购买</button>
</form>



<form style='display:none;' id='formpay' name='formpay' method='post' action='https://pay.paysapi.com'>
    <input name='goodsname' id='goodsname' type='text' value='' />
    <input name='istype' id='istype' type='text' value='' />
    <input name='key' id='key' type='text' value=''/>
    <input name='notify_url' id='notify_url' type='text' value=' '/>
    <input name='orderid' id='orderid' type='text' value='${paySaPi.orderid}'/>
    <input name='orderuid' id='orderuid' type='text' value=''/>
    <input name='price' id='price' type='text' value='${paySaPi.price}'/>
    <input name='return_url' id='return_url' type='text' value='${returnUrl}'/>
    <input name='uid' id='uid' type='text' value=''/>
    <input type='submit' id='submitdemo1'>
</form>

<!-- Jquery files -->
<script type="text/javascript" src="https://cdn.staticfile.org/jquery/1.11.1/jquery.min.js"></script>
<script type="text/javascript">
    $().ready(function(){
        function getistype(){
            return ($("#demo1-alipay").is(':checked') ? "1" : "2" );
        }

        function getPrice(){

            console.log(($("#price").val())) ;
            return ($("#price").val());
        }

        function getOrderid(){
            console.log(($("#orderid").val())) ;
            return ($("#orderid").val());
        }

        $("#demoBtn1").click(function(){
            $.post(
                    "/sell/pays/pay",
                    {

                        istype : getistype(),
                        price : getPrice(),
                        orderid : getOrderid(),

                    },
                    function(data){

                            $("#goodsname").val(data.data.goodsname);
                            $("#istype").val(data.data.istype);
                            $('#key').val(data.data.key);
                            $('#notify_url').val(data.data.notify_url);
                            $('#orderid').val('${paySaPi.orderid}');
                            $('#orderuid').val(data.data.orderuid);
                            $('#price').val('${paySaPi.price}');
                            $('#return_url').val(data.data.return_url);
                            $('#uid').val(data.data.uid);
                            $('#submitdemo1').click();

                    },"json"
            );
        });
    });
</script>


</body>