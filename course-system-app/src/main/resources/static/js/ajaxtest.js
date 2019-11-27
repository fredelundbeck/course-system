$(document).ready(function ()
{
    $.ajax({
        url: "https://jsonplaceholder.typicode.com/posts/1"
    }).then(function (data)
    {
        $('.userId').append('"' + data.userId + '" ,');
        $('.id').append('"' + data.id + '" ,');
        $('.title').append('"' + data.title + '" ,');
        $('.body').append('"' + data.body + '"');
    });
});