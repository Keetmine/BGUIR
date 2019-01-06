document.addEventListener('DOMContentLoaded', function () {

    var getTree = document.getElementById('get-tree');
    var result = document.getElementById('result');
    getTree.addEventListener('click', function (e) {
        result.innerText = '';
        console.log(createTree([], document.querySelector('html'), 0));
    });
    function createTree(dom, nodeItem, depth) {
        result.innerText += '-'.repeat(depth) + nodeItem.nodeName + '\n';
        var children = null;
        if ((children = nodeItem.children).length > 0) {
            for (var i = 0; i < children.length; i++) {
                var child = children[i];
                dom[nodeItem.nodeName] = dom[nodeItem.nodeName] ? dom[nodeItem.nodeName] : [];
                createTree(dom[nodeItem.nodeName], child, depth + 1);
            }
        } else {
            dom.push(nodeItem.nodeName);
        }
        return dom;
    }
});