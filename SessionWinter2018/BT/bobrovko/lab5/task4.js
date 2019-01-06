document.addEventListener('DOMContentLoaded', function () {
    var text = document.getElementById('text-for-format');
    var format = document.getElementById('format');
    var result = document.getElementById('result');
    format.addEventListener('click', function (e) {
        result.innerHTML = text.value.replace(/\n/, '<br>').replace(/([A-Z]{5,})/g, '<span style="font-weight: bold; color: red;">$1</span>');
    });

});