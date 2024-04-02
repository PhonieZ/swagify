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
Go To The Top Of This Repo, And Click The `<> Code` Button, Then Click `Download Zip` Like Below:
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

Where You Replace Everything Before `\Swagify` In `"D:\Program Files\Fractal Softworks\Starsector\mods\Swagify"` With The Path To Your Starsector Mods Folder, ie:
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
### 4.
