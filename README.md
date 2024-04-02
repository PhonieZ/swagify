# Swagify
TBD




# Licensing
TBD




# Workspace Setup
This Is Optional, As This Guide Assumes You Already Have VSCode Set Up For Starsector (Refer To This [Older Guide](https://fractalsoftworks.com/forum/index.php?topic=19532.0) Or [Newer Guide](https://fractalsoftworks.com/forum/index.php?topic=29638.0)).

However, This Guide Will Let You Automatically Compile And Test Changes You Make To The Source Code (Including Debugging), Windows Only.
</br>
</br>
</br>
</br>
</br>
</br>
### 1. Download The Repo:
Go To The Top Of This Repo, And Click The _<> Code_ Button, Then Click _Download Zip_ Like Below:
![1st Step](https://raw.githubusercontent.com/PhonieZ/swagify/main/res/setup_images/1.png)
</br>
</br>
</br>
</br>
</br>
</br>
### 2. Set Up Symlink
This Lets You Put Your Downloaded Repo Anywhere Whilst Still Being Able To Test The Mod, Open CMD And Run The Below Command:

`mklink /d "D:\Program Files\Fractal Softworks\Starsector\mods\Swagify" "D:\Users\user\Documents\GitHub\swagify\build\Swagify"`

Where You Replace Everything Before `\Swagify` In `"D:\Program Files\Fractal Softworks\Starsector\mods\Swagify"` With The Path To Your _Starsector\mods_ Folder, ie:
![Example Path To Starsector Mods Folder](https://raw.githubusercontent.com/PhonieZ/swagify/main/res/setup_images/2-1.png)
</br>
</br>
</br>
![Example Path To Starsector Mods Folder In Symlink Command](https://raw.githubusercontent.com/PhonieZ/swagify/main/res/setup_images/2-2.png)
</br>
</br>
</br>
</br>
</br>
</br>
And You Replace Everything Before `\build` in `"D:\Users\user\Documents\GitHub\swagify\build\Swagify"` With The Path To Your Clone Of This Repo, ie:
![Example Path To Github Repo](https://raw.githubusercontent.com/PhonieZ/swagify/main/res/setup_images/2-3.png)
</br>
</br>
</br>
![Example Path To Github Repo In Symlink Command](https://raw.githubusercontent.com/PhonieZ/swagify/main/res/setup_images/2-4.png)
</br>
</br>
</br>
</br>
</br>
</br>
To Get Something Like This:
![Symlink Example](https://raw.githubusercontent.com/PhonieZ/swagify/main/res/setup_images/2-5.png)
</br>
</br>
</br>
![Full Symlink Command](https://raw.githubusercontent.com/PhonieZ/swagify/main/res/setup_images/2-6.png)
</br>
</br>
</br>
</br>
</br>
</br>
### 3. Set Up The Debug Bat File
Under Your _starsector-core_ Folder, There Should Be A Bat File Named _starsector.bat_, Duplicate It And Name It `debug-starsector.bat`:
![debug-starsector.bat Example](https://raw.githubusercontent.com/PhonieZ/swagify/main/res/setup_images/3-1.png)
</br>
</br>
</br>
</br>
</br>
</br>
Then Start Editing This Bat File, And Insert This String Before The `-Djava.library.path=native\windows` Argument:
```
cd "D:\Program Files\Fractal Softworks\Starsector\starsector-core"
start ..\jre\bin\java.exe -agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=5005 -Dorg.codehaus.janino.source_debugging.enable=true
```
To Get Something Like This:
![debug-starsector.bat Internals Example](https://raw.githubusercontent.com/PhonieZ/swagify/main/res/setup_images/3-2.png)
</br>
</br>
</br>
</br>
</br>
</br>
### 4. Set Up The Tasks
Go To The _res\workspace_setup_ Folder In The Repo, And Paste All The Files In There Into Your `.vscode` Folder (Make It If It Isn't Already There)
(Also If You Already Have A _settings.json_ File, The Important Part Is To Paste In The `"java.project.exportJar.targetPath": "${workspaceFolder}/build/Swagify/jars/swagify.jar",` Line Into There)
</br>
</br>
</br>
</br>
</br>
</br>
Then, Go Into The _tasks.json_ File, And On The Line With The Comment _// Replace This_ , Replace Everything Before The `\debug-starsector.bat` With The Path To Your _starsector-core_ Folder, Replacing All / With \:
![starsector-core Folder Example](https://raw.githubusercontent.com/PhonieZ/swagify/main/res/setup_images/4-1.png)
</br>
</br>
</br>
![tasks.json File Example](https://raw.githubusercontent.com/PhonieZ/swagify/main/res/setup_images/4-2.png)
