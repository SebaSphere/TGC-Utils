# TGC-Utils

## Developers
If you are a mod developer and want to use our update checker there are a few things you need to know.

You will need to have a `json` file that can be access via `http` or `https`. If you just want a quick example check out the `update.json` file in this repo.

| Key           	| Description                                                                                                         	|
|---------------	|---------------------------------------------------------------------------------------------------------------------	|
| mod_id        	| The mod id of the mod.                                                                                              	|
| download_page 	| The download page of the mod, ie Github Releases or Curseforge project files.                                       	|
| mcVersions    	| Each MC version should contain a "latest" and "recommended" key which is each a string containing a mod version.    	|
| modVersions   	| A list of strings each being a version of the mod. The top item (index 0) in the list should be the latest version. 	|

Once you have you're updates file you need to setup your mod to check for the updates.

In your `build.gradle` you need to add a few things:
```groovy
repositories {
	...
    maven { url 'https://jitpack.io' }
}

dependencies {
    modCompile 'com.github.teamgalacticraft:tgc-utils:master-SNAPSHOT'
}
```
This will add TGC-Utils to your project. Now you need to tell your mod to check for updates.
```java
import io.github.teamgalacticraft.tgcutils.api.updatechecker.ModUpdateChecker;

public class MyAwesomeMod implements ModInitializer {
    
    @Override
    public void onInitialize() {
        ModUpdateChecker updateChecker = new ModUpadteChecker(
                "my-awesome-mod", // Your mod id
                "https://example.com/my-awesome-mod/updates.json" // link to raw updates json file
        );
        
        System.out.println("Your update is currently " + updateChecker.getStatus().name());
    }
}
```

And your done! Updates for all!