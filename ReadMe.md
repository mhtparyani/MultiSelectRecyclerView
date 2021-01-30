Note: For perfect results use clickable false for child views in cell layout and clickable true to the parent view in cell layout.

Use:
```
	class YOUR_ADAPTER : MultiChoiceAdapter<YOUR_ADAPTER.RecyclerViewViewHolder>() {
	...
	override fun setActive(view: View, state: Boolean) {
	// Your code on click with respective boolean state
	}
	...
}
```

Add it in your root build.gradle at the end of repositories:
```
	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
 ``` 
Step 2. Add the dependency
```
	dependencies {
	        implementation 'com.github.mhtparyani:MultiSelectRecyclerView:1.0'
	}
```  
