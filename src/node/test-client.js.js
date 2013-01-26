var client = require('./JavaRpcClient');

var instance = new client();

instance.on('message', function(msg){
    console.log('Received a message...');
    console.log(msg);
    console.log("");
});

instance.on('sent', function(msg){
    console.log('Sent a message...');
    console.log(msg);
    console.log("");
});

instance.on('Error', function(msg){
    console.log("Oh no! An error was received!");
    console.log(msg.errorMessage);
    console.log(msg.stackTrace);
    console.log('');
    
    // I'm just gonna go ahead and give up because I'm weak.
    instance.sendGoodbye();
});

instance.on('Hello', function(msg) {
    console.log("Look at that! The server says hi!");
    console.log(msg);
    console.log("");
});

instance.on('Info', function(msg){
    console.log("I received some special info ...");
    console.log(msg.message);
    console.log("");
});


// Here's the full client logic for the test
(function(){
    // Start it up (Hello exchanges happen)
    instance.run();
    
    // Receive acknowledgement of hello
    instance.once('Info', function(){
        // Try echoing something
        instance.sendEcho("ECHO!");
        
        // Receive back the echo and quit.
        instance.once('Info', function(){
            instance.sendGoodbye();
        })
    });
    
})();
