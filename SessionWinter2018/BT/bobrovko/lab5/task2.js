document.addEventListener('DOMContentLoaded', function () {
    var before = document.getElementById('before');
    var after = document.getElementById('after');
    var removeComments = document.getElementById('remove-comments');
    removeComments.addEventListener('click', function (e) {
        after.innerText = before.innerText.replace(/(<!--)[^(\[.*\])].*(-->)/gs, '');
    });

});