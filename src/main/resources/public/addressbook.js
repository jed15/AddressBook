/**
 * Created by jeremydunsmore on 2/16/2017.
 */
var AddressBook = {
     setup :function(){
        $('a').remove();
        
        $.ajax({
            url: "/getBooks"
        }).then(function(books) {
        	for( var i=0;i<books.length ; i++){
        		button=$('<input type="button" value="'+books[i].name+'"/>');
        		button.on('click',AddressBook.displayBook.bind(this,books[i]));
        		$('#books').append(button);
        	}
        });
    },

    displayBook: function  (book){
    	console.log(book)
	}
};

$(AddressBook.setup);
