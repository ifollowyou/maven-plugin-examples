@echo off

echo Deploying...ifollowyou-archetype-java
cd ifollowyou-archetype-java
call mvn clean deploy
cd ..
echo Deploying...ifollowyou-archetype-java...end

echo Deploying...ifollowyou-archetype-parent
cd ifollowyou-archetype-parent
call mvn clean deploy
cd ..
echo Deploying...ifollowyou-archetype-parent...end

echo Deploying...ifollowyou-archetype-webapp
cd ifollowyou-archetype-webapp
call mvn clean deploy
cd ..
echo Deploying...ifollowyou-archetype-webapp...end

echo
echo Done!
pause