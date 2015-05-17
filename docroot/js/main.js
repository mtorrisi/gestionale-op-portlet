YUI().ready('aui-io-plugin', function (Y) {
    if (!window.addEventListener) {
        window.attachEvent('onmessage', receiver);
    } else {
        window.addEventListener('message', receiver, false);
    }

});

function receiver(e){
    console.log(e);
}
