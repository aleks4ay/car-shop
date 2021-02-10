<#import "/spring.ftl" as spring/>

<html lang="en">
<head>
    <title>New User FTL</title>
    <meta charset="utf-8"/>
    <link rel="stylesheet"
          type="text/css"
          href="<@spring.url '/css/style.css'/>"/>
</head>
<body>

    <form method="post" action="newClient">
        <input type="text" name="login" placeholder="your login"/>
        <input type="text" name="email" placeholder="your e-mail"/>
        <input type="password" name="password" />
        <button type="submit">Save</button>
        <button onclick="window.history.back()" type="button">Cancel</button>
    </form>
</body>
</html>


