function adsp�iler(str,from,internal){
var pos=0,pos2=0,newpos=0
if((pos=str.indexOf("[sp�iler]",from))==-1) return str;
if((pos2=str.indexOf("[/sp�iler]"),pos+10)==-1) return str;
newpos=str.indexOf("[sp�iler]",pos+10)
if(newpos<pos2 && newpos!=-1) str=adsp�iler(str,pos+10,true)
if((pos2=str.indexOf("[/sp�iler]",pos+10))==-1) return str;
str=str.substring(0,pos)+makeSpoiler(str.substring(pos+10,pos2))+str.substring(pos2+10,str.length)
if( str.indexOf("[sp�iler]")!=-1 && internal==false) str=adsp�iler(str,0,false)
return str}
function makeSpoiler(txt){
txt="<div class=quote-box style='padding:1px'><cite style='width:100%'>������� ����� <input style='width:60px;margin-left:70%;font-size:10px;' type='button' value='��������' onclick='hideSpoiler(this)'></cite><blockquote style='display:none'>"+txt+"</blockquote></div>"
return txt}
function hideSpoiler(sp){
spoiler=sp.parentNode.parentNode.getElementsByTagName("blockquote")[0]
if(spoiler.style.display=='none'){
spoiler.style.display='inline'
sp.value='������'}
else{
spoiler.style.display='none'
sp.value='��������'}}
if(document.URL.indexOf("viewtopic.php")!=-1){
elm=document.getElementById("pun-main").getElementsByTagName("div")
for(x in elm) if(elm[x].className=="post-content"){
var post=elm[x]
post.innerHTML=adsp�iler(post.innerHTML,0,false)}}
if(form=document.getElementById("form-buttons"))
form.getElementsByTagName("tr")[0].insertCell(14).innerHTML=""