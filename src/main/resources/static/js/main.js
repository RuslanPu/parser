$('.btn').click(function(e) {

    var container = $('.listCost');

    while (container.firstChild) {
        container.removeChild(container.firstChild);
    }
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
            // var tagP = $('.listCost');
            // tagP.innerHTML = '';
            // $(".query").text(search);
            $(".listCost").children("span").remove();
            var number = parseInt(data[data.length-1]).toFixed(2)
            $(".cost").text(number);
            console.log(data.length);

            for(var i = 0; i < data.length - 1; i++) {
                var newElemnt = '<span>'+(i+1)+' '+data[i]+'<br></span>';
                $('.listCost').append(newElemnt);
            }

        }
    })
})