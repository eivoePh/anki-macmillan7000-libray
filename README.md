
## Anki macmillan 7000 记忆库 批量制卡 
此项目用于批量制作Anki卡片，
大体流程：
 * 定义css样式
 * 定义栏目
 * 获取卡片文本列表 * 使用apple TTS 生成语音 * 使用apple dictionary 生成解释 * 将解释，语音合并为 anki 卡片格式
 * 将合成后的文件导入 anki 
 * 配置导入后的记忆库为混乱模式
 * 导出 apkg 给别人或者自己用


## 单词来源
单词列表采用[赛门喵麦克米伦7000高频词记忆卡](https://zhuanlan.zhihu.com/p/27063304)中的单词表
删除了IT/it及其他4个重复单词,最终单词数量为`6140`

## 发音来源
使用Mac United Kingdom Daniel语音

## 配置及生成Dainel语音文件 System -> Accessibility -> Speech -> System Voice: Daniel / Speaking Rate: Normal

使用 `say Hello` 会发音
使用 `say Hello -o Hello.m4a` 会将发音保存为音频文件

## 将sound生成至sound目录
    gen-sound.scala macmillan7000word.list

## 使用ffmpeg 将m4a音频转为mp3或ogg
    ffmpeg -i a.m4a -ab 320k a.mp3

## 单词解释来源
    中文含义来自 Apple Dictionary 牛津英汉汉英词典(Simplified Chinese-English)
    英文含义来自 Apple Dictionary Oxford American Writer's Thesaurus (American English)

## 生成中文含义
* 调节 Apple Dictionary中字典顺序，将`牛津英汉汉英词典(Simplified Chinese-English)`拖动至最上层
* 重新termial 使用 `gen-word.scala macmillan7000word.list zh` 在word目录生成 word.zh.txt

## 生成英文含义
* 调节 Apple Dictionary中字典顺序，将`Oxford American Writer's Thesaurus (American English)`拖动至最上层
* 重新termial 使用 `gen-word.scala macmillan7000word.list en` 在word目录生成 word.en.txt


## 合成anki导入

"第一框"^I"第二框"^I"第三框"

框中包含的html如果需要" 如`style="color:#000"` 改为`style=""color:#000""`


## 导入


## css样式


### 正面模板

```html
<div style="font-size:50px;color:#000;">{{word}}</div>
<br />
<div style="font-size:12px;color:#888">{{symbol}}</div>
<br />
<div>{{sound}}</div>
```

### 中间样式
```css
.card {
 font-family: arial;
 font-size: 14px;
 text-align: left;
 color: ;
 background-color: #fff;

.word{ 
	font-size:50px;color:#000;
}
```


### 背面模板

```html
{{FrontSide}}
<br />
<div class="explain" style="text-align:left;font-size:12px; color: #444;">{{explain}}</div>
```



## 引用
* [赛门喵麦克米伦7000高频词记忆卡](https://zhuanlan.zhihu.com/p/27063304)
* [macmillandictionary](http://www.macmillandictionary.com)
* [zh_CN 简体中文词典](http://download.huzheng.org/zh_CN/)
* [苹果Mac自带词典完美扩充](http://www.jianshu.com/p/c57be986589b)
* [Urinx dict](https://github.com/Urinx/dict)
* [DictUnifier](https://github.com/jjgod/mac-dictionary-kit/)


