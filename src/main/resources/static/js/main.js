$('.btn').click(function(e) {
    e.preventDefault();
    var search = $('.searchInput').val();
    $.ajax({
        url: '/search',
        datatype: 'json',
        type: 'post',
        contentType: "application/json",
        data: JSON.stringify({
            query: search
        }),
        success: function (data) {
            console.log(data);
            $(".query").text(search);
            $(".cost").text(data.query);
        }
    })
})