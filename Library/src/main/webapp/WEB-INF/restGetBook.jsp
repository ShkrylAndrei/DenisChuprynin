<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Devcolibri.com exam REST</title>
</head>

<script src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script type="text/javascript">
    var prefix = '/serviceLibrary/book';

    var RestGet = function() {
        $.ajax({
            type: 'GET',
            url:  prefix + '/' + 1,
            // dataType: 'json',
            // async: true,
            type : "get",
            contentType : "application/json",
            success: function(result) {
                alert('Id: ' + result.id
                        + ', книга: ' + result.name
                        + ', автор: '+ result.author);
            },
            error: function(jqXHR, textStatus, errorThrown) {
                alert(jqXHR.status + ' ' + jqXHR.responseText);
            }
        });
    }
</script>


<body>

    <h3>Это простой пример использования REST c помощью Ajax</h3>

    <button type="button" onclick="RestGet()">Метод GET</button>

</body>
</html>