(function showDiv() {  				
    $(document).ready(function (){
        $('td[type="clicavel"]').click(function(){
        	var id = $(this).attr("value");

			$(".params").each(function(){
				$(this).css("display","none");
			});

			$("#"+id).css("display","block");

        });
    })
})();
