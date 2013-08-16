   $(document).ready(function() {
      $("div").click(function() {
        alert("Hello world!");
      });
      
      //create class
      var test = function(){
    	 this.a = 1;    	 
    	 this.meth=function( a){
    		 console.log(a);
    	 };    	  
      };
      
      //create object and calling
      var obj1 = new test();
      console.log(obj1.a);
      console.log(obj1.meth(67));
      
      //globale variable
      var emp = {
    		   name: "Zara",
    		   age: 10
    	};
      
      console.log(emp.name);
     
      
      var x = [1, 2, 3, 4, 5];
      for (var i = 0; i < x.length; i++) {
    	  console.log(x[i]);
       }
      
      //named function
      function named(){
    	  // do some stuff here
    	  console.log("named function");
    	}
      
      //anonymous function
      var handler = function (){
    	  // do some stuff here
    	  
    	  console.log("anonymous function");
    	};
    	
    	handler();
    	named();
    	
    	 $("li").eq(1).addClass("selected");
    	
    	 
    	 $("li").filter(".middle").addClass("selected1");
    	 
    	 
    	 $("p").find("span").addClass("selected");
    	 
    	 
    	 
    	 
    	 var title = $("em").attr("title");
         $("#divid").text(title);
         
         
//         $("#myimg").attr("src", "/images/jquery.jpg");
         
         
         
         $("em").addClass("selected");
         $("#myid").addClass("highlight");
         
         
         $("li").eq(5).css("color", "orange");
         
         
         $("div:first").width(100);
         $("div:first").css("background-color", "blue");
         
         
         

         $("div").click(function () {
          var content = $(this).html();
          $("#result").text( content );
        });
         
         
         $("#show").click(function () {
             $(".mydiv").show( 1000 );
          });

          $("#hide").click(function () {
             $(".mydiv").hide( 1000 );
          });


      
   });