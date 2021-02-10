<#import "/spring.ftl" as spring/>

<html lang="en">
<head>
    <title>User List</title>
</head>
<body>
<h1>User List</h1>


<table>
    <#list clients as user>
        <tr>
            <td>${user_index + 1}</td>
            <td>${user.id}</td>
            <td>${user.login}</td>
            <td>${user.email}</td>
            <td><input type="checkbox" <#if (user.enabled)>checked</#if> disabled> </td>
            <td>${user.registred}</td>
            <td><a href="client?action=update&id=${user.id}">Update</a></td>
    </#list>
</table>
<button onclick="window.history.back()" type="button">Back</button>

</body>
</html>