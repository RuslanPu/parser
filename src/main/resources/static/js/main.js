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
            // $(".query").text(search);
            var number = parseInt(data[107]).toFixed(2)
            $(".cost").text(number);

            for(var i = 1; i <= 100; i++) {
                var newElemnt = '<span>'+i+' '+data[i]+'<br></span>';
                $('.listCost').append(newElemnt);
            }

        }
    })
})