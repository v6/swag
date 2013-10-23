<?
$SiteNameURL = $_SERVER['HTTP_HOST'];
 
switch (strtolower($SiteNameURL)) {
 
case "artofacoustics.com": //MUST BE LOWER CASE
            include 'artindex.html';
            break;
 
case "www.artofacoustics.com": //MUST BE LOWER CASE
            include 'artindex.html';
            break; 
 
 case "sonexfoam-online.com": //MUST BE LOWER CASE
            include 'sonexindex.html';
            break;
			
case "www.sonexfoam-online.com": //MUST BE LOWER CASE
            include 'sonexindex.html';
            break;

 case "sonexacoustics.com": //MUST BE LOWER CASE
            include 'sonexindex.html';
            break;
			
case "www.sonexacoustics.com": //MUST BE LOWER CASE
            include 'sonexindex.html';
            break;
 
default:
            include 'artindex.html';
 
}
?>