<html>
<head>
    <meta charset="utf-8">
    <title>卖家商品列表</title>
<#include "../common/head.ftl">
</head>
<body>
<div id="wrapper" class="toggled">
<#--content-->
    <div id="page-content-wrapper">
        <div class="container">
            <div class="row clearfix">
                <div class="col-md-2 column">
                </div>
                <div class="col-md-6 column">
                    <form class="form-horizontal" role="form" action="/sell/seller/login" method="post">
                        <div class="form-group">
                            <label for="inputEmail3" class="col-sm-2 control-label">Username</label>
                            <div class="col-sm-10">
                                <input name="username" type="text" class="form-control" id="inputEmail3" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="inputPassword3" class="col-sm-2 control-label">Password</label>
                            <div class="col-sm-10">
                                <input name="password" type="password" class="form-control" id="inputPassword3" />
                            </div>
                        </div>
                        <div style="color: crimson;padding-left: 100px"><h4> <strong>${msg}</strong></h4></div>
                        <div class="form-group">
                            <div class="col-sm-offset-2 col-sm-10">
                                <div class="checkbox">
                                    <label><input type="checkbox" />Remember me</label>
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-offset-2 col-sm-10">
                                <button type="submit" class="btn btn-default">Sign in</button>
                            </div>
                        </div>
                    </form>
                </div>
                <div class="col-md-4 column">
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>