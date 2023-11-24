# YAAUM

---

```
      ___           ___           ___           ___           ___     
     |\__\         /\  \         /\  \         /\__\         /\__\    
     |:|  |       /::\  \       /::\  \       /:/  /        /::|  |   
     |:|  |      /:/\:\  \     /:/\:\  \     /:/  /        /:|:|  |   
     |:|__|__   /::\~\:\  \   /::\~\:\  \   /:/  /  ___   /:/|:|__|__ 
     /::::\__\ /:/\:\ \:\__\ /:/\:\ \:\__\ /:/__/  /\__\ /:/ |::::\__\
    /:/~~/~    \/__\:\/:/  / \/__\:\/:/  / \:\  \ /:/  / \/__/~~/:/  /
   /:/  /           \::/  /       \::/  /   \:\  /:/  /        /:/  / 
   \/__/            /:/  /        /:/  /     \:\/:/  /        /:/  /  
                   /:/  /        /:/  /       \::/  /        /:/  /   
                   \/__/         \/__/         \/__/         \/__/    
```

---

__YAAUM__ - Yet Another Application Usage Monitor -

## Summary

__Min SDK:__ 24;

## Contribution

### GitHooks

Please, execute `./gradlew installGitHookTask` to move `config/githook/pre-commit` to `.git/hooks`.

Pre-commit tasks:


- `./gradlew detekt`;
- `./gradlew lintKotlin`.
