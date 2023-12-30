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

__YAAUM__ - Yet Another Application Usage Monitor - versatile application tracking tool designed to
provide users with detailed insights into their digital habits.

## Introduction

This app is designed to empower you to make the most of your time.

With intuitive analytics, it empowers users to monitor and manage their app usage effectively,
promoting a healthier and more mindful interaction with their devices.

Analytics dashboard provides a clear overview of daily, weekly, and monthly activities,
enabling to identify areas for optimization.

## Summary

__Min SDK:__ 24;

__Target/compiled SDK:__ 33;

### Key technologies and aspects

__Architecture:__

- multi-module;
- MVI.

__Code-level:__

- Kotlin;
- Jetpack:
    - Room;
    - DataStore;
    - Compose;
- [Voyager](https://github.com/adrielcafe/voyager);
- [Koin](https://github.com/InsertKoinIO/koin);

__Tests & verifications:__

- [konsist](https://github.com/LemonAppDev/konsist);

## Contribution

### GitHook

Please, execute `./gradlew installGitHookTask` to move `config/githook/pre-commit` to `.git/hooks`.

Pre-commit tasks:

- `./gradlew detekt`;
- `./gradlew lintKotlin`.
