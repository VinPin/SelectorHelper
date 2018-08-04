# SelectorHelper
Android 代码生成Shape和Selector及各种组合，从此告别xml文件。

## 添加依赖
```

```

## 如何使用
1. 在全局的Application中初始化
```
//SelectorHelper 初始化
SelectorHelper.init(this);
```
2. 创建Shape
```
GradientDrawable drawable = ShapeHelper.getInstance()
           .solidColor(R.color.colorAccent)
           .stroke(dp2px(1), R.color.colorPrimary)
           .cornerRadius(dp2px(5))
           .gradient(ShapeHelper.BOTTOM_TOP, R.color.colorAccent, R.color.colorPrimary)
           .create()
```
每个方法名对应于shape的xml中的属性，每个方法都有重载的方法来满足你的需求。
3. 创建ShapeSelector
```
StateListDrawable drawable = SelectorHelper.shapeSelector()
                                .pressed(true, ShapeHelper.getInstance()
                                        .solidColor(R.color.colorPrimary)
                                        .cornerRadius(dp2px(5))
                                        .create())
                                .defaultShape(ShapeHelper.getInstance()
                                        .solidColor(R.color.colorAccent)
                                        .cornerRadius(dp2px(5))
                                        .create())
                                .create()
```
每个方法名对应于selector的xml中item中的state值，每个方法都有重载的方法来满足你的需求。
4. 创建ColorSelector
```
ColorStateList drawable = SelectorHelper.colorSelector()
                        .enabled(false, "#9B9B9B")
                        .defaultColor(R.color.colorAccent)
                        .create()
```
每个方法名对应于selector的xml中item中的state值，每个方法都有重载的方法来满足你的需求。
5. 创建DrawableSelector
```
 StateListDrawable drawable = SelectorHelper.drawableSelector()
                                .enabled(false, ShapeHelper.getInstance()
                                        .solidColor("#9B9B9B")
                                        .cornerRadius(dp2px(5))
                                        .create())
                                .defaultDrawable(ShapeHelper.getInstance()
                                        .solidColor(R.color.colorAccent)
                                        .cornerRadius(dp2px(5))
                                        .create())
                                .create()
```
每个方法名对应于selector的xml中item中的state值，每个方法都有重载的方法来满足你的需求。
6. 创建Shape、ShapeSelector、ColorSelector、DrawableSelector的组合来满足你的需求。
