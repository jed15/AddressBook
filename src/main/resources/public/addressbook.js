/**
 * Created by jeremydunsmore on 2/16/2017.
 */
var AddressBook = {
     setup :function(){
        $('.book').remove();
        $('body').append($('<div id="buddyArea">').hide());
        var buddyForm=$('<form id="buddyForm">'
        		+'<p>Name: <input class="name-input" type="text"/></p>'
        		+'<p>Address: <input class="address-input" type="text"/></p>'
        		+'<p>Phone: <input class="phone-input" type="text"/></p>'
        		+'<p><input class="create" type="submit" value="Add Buddy" /></p>'
                +'</form>').hide();
        $('body').append(buddyForm);
        $('#bookForm .create').on('click', AddressBook.createBook)
        $.ajax({
            url: "/getBooks"
        }).then(function(books) {
        	for( var i=0;i<books.length ; i++){
        		AddressBook.listBook(books[i]);
        	}
        });
    },

    listBook: function(book){
    	var text = book.name || book.id
    	var button=$('<input type="button" id="book'+book.id+'" value="'+text+'"/>');
		button.on('click',AddressBook.displayBook.bind(this,book));
		$('#books').append(button);
    },
    displayBook: function  (book){
    	var area= $('#buddyArea').empty();
    	area.append($('<h2>').text(book.name));
    	var table=$('<table>').append('<tr><th>name</th><th>phone</th><th>addresss</th></tr>');
    	var buddies=book.buddies
    	for(var i=0;i<buddies.length; i++){
    		var name =$('<td>').text(buddies[i].name);
    		var phone = $('<td>').text(buddies[i].phone);
    		var address= $('<td>').text(buddies[i].address);
    		table.append($('<tr>').append(name).append(phone).append(address));
    	}
    	area.append(table);
    	var button=$('<input type="button" value="Create Buddy"/>');
		button.on('click',AddressBook.newBuddy.bind(this,book));
		area.append(button)
    	area.show();
	},
	
	newBuddy : function(book){
		 	$('#buddyForm .create').on('click', function(event){ 
		 		event.preventDefault();
		 	$.ajax({
	           url: "/add",
	           type: 'GET',
	           data: { 
	        	   bookid: book.id, 
	        	   name : $('#buddyForm .name-input').val(), 
	        	   phone : $('#buddyForm .phone-input').val(), 
	        	   address : $('#buddyForm .address-input').val() 
	        	   }
	        }
		 	).then(function(book) {
		 			$('#book'+book.id).remove()
		 			AddressBook.listBook(book);
	        		AddressBook.displayBook(book);
	        })});
			$('#buddyForm').dialog();
	},
	
	createBook : function(event){
		event.preventDefault();
		$.ajax({
	           url: "/create",
	           type: 'GET',
	           data: { 
	        	   name : $('#bookForm .name-input').val(), 
	        	   }
	        }
		 	).then(function(book) {
		 			AddressBook.listBook(book);
	        		AddressBook.displayBook(book);
	        });
		
	}

};

$(AddressBook.setup);
