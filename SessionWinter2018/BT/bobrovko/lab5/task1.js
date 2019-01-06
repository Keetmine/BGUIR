document.addEventListener('DOMContentLoaded', function () {
    var checkButton = document.getElementById('check');
    var email = document.getElementById('email');
    var result = document.getElementById('result');
    checkButton.addEventListener('click', function (e) {
        var val = email.value;
        result.innerText = "Email is " + (/^(\w+[\.\-]?)+\w\@(\w+[\.\-]?\w)+([\.]\w+)+$/.test(val) ? "" : "not ") + 'valid!';
    });
});