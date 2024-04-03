# Swagify
TBD
</br>
</br>
</br>
</br>
</br>

## Swagify - Extension Packs
</br>
</br>

### What Is An Extension Pack?
An Extension Pack Allows Anyone To Expand On The Swag Portraits In This Mod Without Having To Modify The Core Swagify Mod Itself, So It Is Possible To Add Swag Support To A Mod Like Iron Shell Or Scalar Tech Solutions
</br>
</br>

### How Do I Make One?
You Follow This Tutorial Below:
</br>
</br>
</br>
_(Also For Swagify: The Swagening, Just Use The Mod Template In The Same Folder As Referenced Below, But All You Need To Do Is Just Put Your Copied Portraits Folder Straight In The Graphics Folder)_
</br>
</br>

### 1. Download The Template:
Go To The _res/extension_pack_templates_ Folder In The Repo, And Download The _swagify_ Folder:
![1st Step](https://raw.githubusercontent.com/PhonieZ/swagify/main/res/setup_images/f1.png)
</br>
</br>
</br>
</br>
</br>

### 2. Assemble The Portraits
Go To The _graphics_ Folder In The Mod You Are Making An Extension Pack Of (In The Example Ironshell Is Used), And Copy The _portraits_ Folder Into The _graphics\phoni\swagify_ In The Extension Pack Template:
![Iron Shell Portraits Folder](https://raw.githubusercontent.com/PhonieZ/swagify/main/res/setup_images/f2-1.png)
</br>
</br>
</br>
![Iron Shell Portraits In Extension Pack](https://raw.githubusercontent.com/PhonieZ/swagify/main/res/setup_images/f2-2.png)
</br>
</br>
</br>
Next, In The Extension Pack, Delete All The Portraits You Aren't Going To Swagify, Then Get To Editing:
![Swag Iron Shell Portrait](https://raw.githubusercontent.com/PhonieZ/swagify/main/res/setup_images/f2-3.png)
</br>
</br>
</br>
</br>
</br>

### 3. Load The Portraits Into The Game
Go To The _data\world\factions_ Folder In Your Extension Pack, Then Like In The Provided Example, Put A Path To Your Portraits Into Both The Male And Female Entries of The _swag.faction_ File:
![Swag Iron Shell Portrait](https://raw.githubusercontent.com/PhonieZ/swagify/main/res/setup_images/f2-3.png)
</br>
</br>
</br>
![Iron Shell Portrait Referenced In swag.faction](https://raw.githubusercontent.com/PhonieZ/swagify/main/res/setup_images/f3.png)
</br>
</br>
</br>
</br>
</br>

### 4. Complete The _mod.json_ File:
Finally, Go To The _mod.json_ File, And Be Sure To Change The _id_,_name_,_author_ And _description_ Fields As Approriate, Then Feel Free To Post Your Extension Pack Onto The Mod Index Or Wherever:
</br>
![Example mod_info.json](https://raw.githubusercontent.com/PhonieZ/swagify/main/res/setup_images/f4.png)
</br>
</br>
</br>
</br>
</br>
</br>
</br>
</br>
</br>
</br>
</br>

# Licensing
All Swag Portraits Fall Under _Starsector's License_ For The Vanilla Portraits
</br>
</br>
</br>
All Code Is Mine, So Falls Under The _MIT License_
</br>
</br>
</br>
</br>
</br>

## Credits
Thanks To _Jaghaimo_ For Providing Some Of The Steps For The Workspace Setup, Though I Still Had To Figure Some Things Out Myself
</br>
</br>
</br>
Thanks To _PAGSM's Makers_ For Providing Inspiration For What All The Swag Portraits I Made Should Look Like (I Used Balashi As My Main Reference), Without Them My Art Direction Probably Would Have Been Poorer
</br>
</br>
</br>
And Most Of All, Thanks To _Big Brain Energy_ For Giving Me The Greatest Idea Of Giving Sebestyen Swag Glasses, You Are The Only Reason I Thought To Make This Mod
</br>
</br>
</br>
![Swagviss Sebestyen](https://raw.githubusercontent.com/PhonieZ/swagify/main/build/Swagify/graphics/phoni/swagify/factions/crest_swag.png)
</br>
</br>
</br>
</br>
</br>
</br>
</br>
</br>
</br>
</br>
</br>

# Workspace Setup
This Is Optional, As This Guide Assumes You Already Have VSCode Set Up For Starsector (Refer To This [Older Guide](https://fractalsoftworks.com/forum/index.php?topic=19532.0) Or [Newer Guide](https://fractalsoftworks.com/forum/index.php?topic=29638.0))

However, This Guide Will Let You Automatically Compile And Test Changes You Make To The Source Code (Including Debugging), Windows Only
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

### 2. Set Up Symlink:
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

### 3. Set Up The Debug Bat File:
Under Your _starsector-core_ Folder, There Should Be A Bat File Named _starsector.bat_, Duplicate It And Name It `debug-starsector.bat`:
![debug-starsector.bat Example](https://raw.githubusercontent.com/PhonieZ/swagify/main/res/setup_images/3-1.png)
</br>
</br>
</br>
</br>
</br>
</br>
Then Start Editing This Bat File, And Insert This String Before The `-Djava.library.path=native\windows` Argument (Replacing The Path In The cd Line With The Path To Your _starsector-core_ Folder):
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

### 4. Set Up The Tasks:
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
