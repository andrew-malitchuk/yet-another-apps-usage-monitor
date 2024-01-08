# YAAUM

## config

Configuration files for [detekt](detekt) and [githook](githook).

### GitHook

Please, execute `./gradlew installGitHookTask` to move `config/githook/pre-commit` to `.git/hooks`.

Pre-commit tasks:

- `./gradlew detekt`;
- `./gradlew lintKotlin`.
