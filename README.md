# RemoteGUI
基于Bungeecord的GUI交互窗口
它需要 **Java 8** 或更高版本。

## 特征
- 在BC上向玩家进行GUI交互
- 依赖MQEasy
- 支持API

## API
```java
    /**
     * 向玩家展示GUI
     *
     * @param String         target
     * @param SendableGUI    gui
     * @param GUIController  controller
     */
public static void showRemotePlayerGui(String target, SendableGUI gui, GUIController controller) {

        
    }
    /**
     * 向玩家展示GUI
     *
     * @param String         target
     * @param SendableGUI    gui
     */
    public static void showRemotePlayerGui(String target, CallableGUI gui) {
         
    }
    /**
     * 向玩家展示GUI
     *
     * @param String         target
     */
    public static void closeRemotePlayerGui(String target) {
        
    }
```
## 编译
您需要使用 Java 8+ 编译它并且必须使用 gradle。
下载后，使用 cmd 或您的 IDE 运行此 gradle 命令。
```
gradle install
```
