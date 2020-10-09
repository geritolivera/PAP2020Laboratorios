$(document).ready(function (){
    $('#institutos').change(function (){
        $.ajax({
            url: '/src/GetListas',
            type: 'post',
            data: "tipo = 'institutos'",
            success: function (response){
                var len = response.length;
                $('institutos').empty();
                for(var i=0; i<len ; i++){
                    var inst = response[i];

                    $("#institutos").append("<option value='"+inst+"'>"+inst+"</option>")
                }
            }
        })
    })
})