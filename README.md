Ce projet à pour but de récupérer des carte du jeux Hearthstone de Blizzard.

Dans un premier temps on doit choisir quelle extension du jeu nous intéresse, j'utilise un ReyclerView pour les extensions
(screen :https://raw.githubusercontent.com/LucasDouillard/ProjetMobile3A/master/screens/Screenshot_2021-05-24-22-28-54-371_com.example.projetmobile.jpg )


Ensuite grace à une API on va récupérer la liste des cartes de cette extension, cette liste sera également affichée grâce à une RecyclerView
(screen : https://raw.githubusercontent.com/LucasDouillard/ProjetMobile3A/master/screens/Screenshot_2021-05-24-22-29-00-464_com.example.projetmobile.jpg)

En cliquant sur un nom de carte on obtient des informations sur cette dernière en plus de voir son image
(screen :https://raw.githubusercontent.com/LucasDouillard/ProjetMobile3A/master/screens/Screenshot_2021-05-24-22-29-05-610_com.example.projetmobile.jpg )

Vous verrez dans mon code que j'ai essayé d'implémenter le cache mais l'API ne prend pas en charge le cache 

Lien de l'api :https://omgvamp-hearthstone-v1.p.rapidapi.com/cards 
(il faut utiliser une clée fourni par le site rapidapi en s'inscrivant : rapidapi-key=bf7c3ced5bmsh161ba77a16443fep14bcc7jsn294e5fd5606b)

