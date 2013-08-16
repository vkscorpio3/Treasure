   $(document).ready(function() {
      $("div").click(function() {
        alert("Hello world!");
      });
      
      
      var emp = {
    		   name: "Zara",
    		   age: 10
    		};
      
      console.log(emp);
      
      var x = [1, 2, 3, 4, 5];
      for (var i = 0; i < x.length; i++) {
    	  console.log(x[i]);
       }
      
      //named function
      function named(){
    	  // do some stuff here
    	}
      
      //anonymous function
      var handler = function (){
    	  // do some stuff here
    	}
   });