$(document).ready(function() {
    $("body").ready(function () {
        $("#header").load("Header.html");
    });
     $("body").ready(function () {
        $("#wowslider-container3").load("slider.html");
    });
     $("body").ready(function () {
        $("#news").load("news.html");
    });
    $("body").ready(function () {
        $("#footer").load("footer.html");
    });
    $( function() {
    $( "#dob" ).datepicker({ dateFormat: 'yy-mm-dd'});
  } );
  /*$(function(){
      $("#10th").click(function(){
          $("#basic").toggle();
      });
  });*/
});
$(document).on("click", function(e){
    if($(e.target).is("#10th")){
      $("#basic").show();
       $("#foundation").hide();
        $("#fresher").hide();
        $("#dropper").hide();
       
    }else if($(e.target).is("#11th")){
        $("#foundation").show();
        $("#basic").hide();
        $("#fresher").hide();
        $("#dropper").hide();
    }
    else if($(e.target).is("#12th")){
        $("#fresher").show();
        $("#basic").hide();
          $("#foundation").hide();
          $("#dropper").hide();
    }
    else if ($(e.target).is("#target")){
        $("#dropper").show();
        $("#fresher").hide();
        $("#basic").hide();
          $("#foundation").hide();
        
    }
});
