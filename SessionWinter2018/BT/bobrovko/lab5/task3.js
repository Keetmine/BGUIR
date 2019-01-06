document.addEventListener('DOMContentLoaded', function () {
    var before = document.getElementById('before');
    var after = document.getElementById('after');
    var removeTags = document.getElementById('remove-tags');
    removeTags.addEventListener('click', function (e) {
        after.innerText = before.innerText.replace(/<[^!][^>]*>/g, '');
    });

});